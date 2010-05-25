namespace :i18n do

  desc 'Update Gherkin Gem'
  task :update_gherkin_gem do
    system "gem update gherkin"
    system "gem cleanup gherkin"
  end

  desc 'Add new Lib to Project and Remove old Lib'
  task :update_gherkin_jar do
    require 'rubygems'
    require 'gherkin/i18n'
    require 'hpricot'
    require 'open-uri'
    require 'net/http'


    def available_versions
      url = "http://cukes.info/maven/gherkin/gherkin"
      doc = open(url) { |f| Hpricot(f) }
      versions = []
      (doc/"a").each do |row|
        versions << row.inner_text.gsub(/\//,'') if row.inner_text.include?("/")
      end
      versions
    end

    def download_jar(version)
      Net::HTTP.start("cukes.info") { |http|
        resp = http.get("/maven/gherkin/gherkin/#{version}/gherkin-#{version}.jar")
        open("release/modules/ext/gherkin-#{version}.jar", "wb") { |file|
          file.write(resp.body)
        }
      }
      puts "New Gherkin Jar File Downloaded: #{version}"
    end
    
    def update_project(old_version, new_version)
      filename = "nbproject/project.xml"
      doc = open(filename) { |f| Hpricot.XML(f) }
      document = doc.to_s
      document.gsub!("gherkin-#{old_version}.jar", "gherkin-#{new_version}.jar")
      open(filename, "wb") do |file|
        file.write(document)
      end
      puts "#{filename} updated!"
    end

    latest_available_version = available_versions.last

    gem_version = Gem.source_index.find_name('gherkin').first.version.to_s
    jar_version = Dir.entries("release/modules/ext").collect{|name| name.sub('.jar','').sub('gherkin-','') if name.include?(".jar")}.compact

    if gem_version == latest_available_version and jar_version.last == latest_available_version
      puts "Module UpToDate!"
    end

    unless jar_version.last == latest_available_version
      download_jar(latest_available_version)
      update_project(jar_version, latest_available_version)
    end

  end
end