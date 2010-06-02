module ProjectXml

  PROJECT_XML_FILE = "nbproject/project.xml"

  def self.update_jar_version(old_version, new_version)
    old_file_name = "gherkin-#{old_version}.jar"
    new_file_name = "gherkin-#{new_version}.jar"
    doc = open(PROJECT_XML_FILE) { |f| Hpricot.XML(f) }
    document = doc.to_s
    document.gsub!(old_file_name, new_file_name)
    open(PROJECT_XML_FILE, "wb") do |file|
      file.write(document)
    end
    puts "#{PROJECT_XML_FILE} updated!"
  end
end