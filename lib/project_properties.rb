module ProjectProperties

  PROJECT_PROPERTIES_FILE = "nbproject/project.properties"

  def self.update_version(major_version, minor_version)
    doc = open(PROJECT_PROPERTIES_FILE) { |f| Hpricot.XML(f) }
    document = doc.to_s
    document.gsub!(/spec.version.base=(\d+\.\d+)/, "spec.version.base=#{major_version}.#{minor_version}")
    open(PROJECT_PROPERTIES_FILE, "wb") do |file|
      file.write(document)
    end
    puts "#{PROJECT_PROPERTIES_FILE} updated!"
  end

end