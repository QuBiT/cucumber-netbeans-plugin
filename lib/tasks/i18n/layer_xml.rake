namespace :i18n do
  desc 'Update i18n Part of Layer XML File'
  task :update_layer_xml_file do
    require 'rubygems'
    require 'hpricot'
    require 'open-uri'

    def existing_template_filenames
      Dir.entries("src/qubit/cucumber/editor/templates/i18n").collect{|name| name.sub('.feature','') if name.include?(".feature")}.compact
    end

    def create_xml_for_template(language, position)
      "<file name=\"#{language}.feature\" url=\"templates/i18n/#{language}.feature\">
          <attr name=\"SystemFileSystem.localizingBundle\" stringvalue=\"qubit.cucumber.editor.templates.i18n.Bundle\"/>
          <attr name=\"template\" boolvalue=\"true\"/>
          <attr name=\"position\" intvalue=\"#{position}\"/>
        </file>"
    end

    def remove_old_entries
      url = "src/qubit/cucumber/editor/layer.xml"
      doc = open(url) { |f| Hpricot.XML(f) }
      document = doc.to_s
      mainfolder = ""
      (doc/"filesystem/folder").each do |mfolder|
        mainfolder = mfolder if mfolder.attributes['name'] == 'Templates'
      end
      subfolder = ""
      (mainfolder/"folder").each do |sfolder|
        subfolder = sfolder if sfolder.attributes['name'] == 'Cucumber'
      end
      # remove old entries
      (subfolder/"file").each do |template_file|
        document.sub!(template_file.to_s, '') if template_file.attributes['url'].include?("/i18n/")
      end

      open("src/qubit/cucumber/editor/layer.xml", "wb") do |file|
        file.write(document)
      end
    end

    def add_new_entries
      url = "src/qubit/cucumber/editor/layer.xml"
      doc = open(url) { |f| Hpricot.XML(f) }
      document = doc.to_s
      mainfolder = ""
      (doc/"filesystem/folder").each do |mfolder|
        mainfolder = mfolder if mfolder.attributes['name'] == 'Templates'
      end
      subfolder = ""
      (mainfolder/"folder").each do |sfolder|
        subfolder = sfolder if sfolder.attributes['name'] == 'Cucumber'
      end

      counter = (subfolder/"file").size + existing_template_filenames.size
      existing_template_filenames.reverse.each do |language|
        document.sub!((subfolder/"file").last.to_s, (subfolder/"file").last.to_s+"\n"+create_xml_for_template(language, counter))
        counter-=1
      end

      open("src/qubit/cucumber/editor/layer.xml", "wb") do |file|
        file.write(document)
      end
    end

    remove_old_entries
    add_new_entries

  end


end