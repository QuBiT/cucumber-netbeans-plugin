desc "Generate feature.nbs with support for all of Gherkin's translations"
task :i18n_generate do
  require 'erb'
  require 'gherkin/i18n'

  def gherkin_keywords(*keys)
    Gherkin::I18n.keyword_regexp(*keys).split(/\|/).map do |kw| 
      kw = kw.gsub("\\*", "*") # Remove escaping of the *
      kw = kw.gsub("'", "\\\\'") # Escape single quotes
      '"'+unicode_escape(kw)+'"'
    end.join(' | ')
  end

  def unicode_escape(word)
    word = word.unpack("U*").map do |c|
      if c > 127
        "\\u%04x" % c
      else
        c.chr
      end
    end.join
  end

  File.open(File.dirname(__FILE__) + '/src/qubit/cucumber/editor/feature.nbs', "wb") do |io|
    template  = ERB.new(IO.read(File.dirname(__FILE__) + '/src/qubit/cucumber/editor/feature.nbs.erb'))
    io.write(template.result(binding))
  end
end
