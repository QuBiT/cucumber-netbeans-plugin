namespace :i18n do
  desc 'Update i18n Bundle.properties'

  task :update_bundle_properties do
    require 'rubygems'
    require 'hpricot'
    require 'open-uri'
    require 'yaml'

    def existing_template_filenames
      Dir.entries("src/qubit/cucumber/editor/templates/i18n").collect{|name| name.sub('.feature','') if name.include?(".feature")}.compact
    end
  
    def download_i18n_yml_file
      YAML::load(open('http://github.com/aslakhellesoy/gherkin/raw/master/lib/gherkin/i18n.yml'))
    end

    def build_bundle_properties(settings)
      result = ""
      existing_template_filenames.each do |name|
        yml_name = settings[name]['name']
        result << "Templates/Cucumber/#{name}.feature=#{yml_name} Example Feature\n"
      end
      result
    end

    def write_bundle_properties(properties)
      open("src/qubit/cucumber/editor/templates/i18n/Bundle.properties", "wb") do |file|
        file.write(properties)
      end
    end

    settings = download_i18n_yml_file
    properties = build_bundle_properties(settings)
    write_bundle_properties(properties)

  end
end
