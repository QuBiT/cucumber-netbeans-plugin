module ManifestMf

  MANIFEST_MF_FILE = "manifest.mf"

  def self.update_patch_version(patch_version)
    doc = open(MANIFEST_MF_FILE) { |f| Hpricot.XML(f) }
    document = doc.to_s
    document.gsub!(/OpenIDE-Module-Implementation-Version: (\d+)/, "OpenIDE-Module-Implementation-Version: #{patch_version}")
    open(MANIFEST_MF_FILE, "wb") do |file|
      file.write(document)
    end
    puts "#{MANIFEST_MF_FILE} updated!"
  end
end