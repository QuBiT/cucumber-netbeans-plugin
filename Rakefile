desc "Generate feature.nbs with support for all of Gherkin's translations"
task :i18n_generate do
  require 'erb'
  require 'gherkin/i18n'

  def gherkin_keywords(*keys)
    Gherkin::I18n.keyword_regexp(*keys).split(/\|/).map do |kw| 
      kw = kw.gsub("\\*", "*") # Remove escaping of the *
      kw = kw.gsub("'", "\\\\'") # Escape single quotes
      '"' + Gherkin::I18n.unicode_escape(kw) + '"'
    end.join(' | ')
  end

  def gherkin_language_keys()
    Gherkin::I18n.send(:languages).keys.sort.map do |lid|
      '"' + lid + '"'
    end.join(' | ')
  end

  File.open(File.dirname(__FILE__) + '/src/qubit/cucumber/editor/feature.nbs', "wb") do |io|
    template  = ERB.new(IO.read(File.dirname(__FILE__) + '/src/qubit/cucumber/editor/feature.nbs.erb'))
    io.write(template.result(binding))
  end
end
