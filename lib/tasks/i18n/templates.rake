namespace :templates do
  desc "Download Latest Examples and create Templates"
  task :recreate_from_github do
    require 'rubygems'
    require 'hpricot'
    require 'open-uri'

    def find_available_languages
      url = "http://github.com/aslakhellesoy/cucumber/tree/master/examples/i18n"
      doc = open(url) { |f| Hpricot(f) }
      languages = []
      (doc/"div#browser/table//tr/td.content/a").each do |row|
        languages << row.inner_text.gsub(/\//,'') if row.inner_text.include?("/")
      end
      languages
    end

    def find_available_files_for(language)
      url = "http://github.com/aslakhellesoy/cucumber/tree/master/examples/i18n/#{language}/features"
      doc = open(url) { |f| Hpricot(f) }
      files = []
      (doc/"div#browser/table//tr/td.content/a").each do |row|
        files << row.inner_text if row.inner_text.include?(".feature")
      end
      files
    end

    def copyright_info(lang,fname)
      info = "# Source: http://github.com/aslakhellesoy/cucumber/blob/master/examples/i18n/#{lang}/features/#{fname}\n"
      info << "# Updated: #{Time.now}\n"
    end

    def create_template_for(filename, language)
      url = "http://github.com/aslakhellesoy/cucumber/raw/master/examples/i18n/#{language}/features/#{filename}"
      doc = open(url) { |f| Hpricot(f) }
      open("src/qubit/cucumber/editor/templates/i18n/#{language}.feature", "wb") do |file|
        feature = doc.to_original_html
        feature.sub!("\n", "\n"+copyright_info(language,filename))
        file.write(feature)
      end
    end

    def recreate_templates(languages)
      languages.each do |language|
        file_names = find_available_files_for(language)
        create_template_for(file_names.first, language) unless file_names.size == 0
      end
    end

    languages = find_available_languages
    recreate_templates(languages)

  end

end