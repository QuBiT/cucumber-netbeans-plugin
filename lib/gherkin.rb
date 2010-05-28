module Gherkin
  require 'rubygems'
  require 'gherkin/i18n'
  require 'net/http'
  require 'hpricot'
  require 'open-uri'
  require 'fileutils'

  HOMEPAGE = "cukes.info"
  MAVEN_REPOSITORY = "http://cukes.info/maven/gherkin/gherkin"
  LOCAL_STORAGE = "release/modules/ext"

  def self.gem_version
    Gem.source_index.find_name('gherkin').first.version.to_s
  end

  def self.jar_version
    Dir.entries(LOCAL_STORAGE).collect{|name| name.sub('.jar','').sub('gherkin-','') if name.include?(".jar")}.compact.last
  end

  def self.latest_version
    self.available_versions.last
  end

  def self.update_available?
    self.update_check
  end

  def self.update_check
    update = false
    if self.gem_version < self.latest_version
      puts "Gem Update Available"
      update = true
    end
    if self.jar_version < self.latest_version
      puts "Jar Update Available"
      update = true
    end
    if update
      puts "--> Updates Available!"
    else
      puts "--> Nothing to update."
    end
    return update
  end

  def self.available_versions
    doc = open(MAVEN_REPOSITORY) { |f| Hpricot(f) }
    versions = []
    (doc/"a").each do |row|
      versions << row.inner_text.gsub(/\//,'') if row.inner_text.include?("/")
    end
    versions
  end

  def self.download_jar(version)
    filename = "gherkin-#{version}.jar"
    Net::HTTP.start(HOMEPAGE) { |http|
      resp = http.get("/maven/gherkin/gherkin/#{version}/#{filename}")
      open("#{LOCAL_STORAGE}/#{filename}", "wb") { |file|
        file.write(resp.body)
      }
    }
    puts "New Gherkin Jar File Downloaded: #{filename}"
  end

  def self.delete_jar(version)
    filename = "gherkin-#{version}.jar"
    FileUtils.rm filename
  end

end