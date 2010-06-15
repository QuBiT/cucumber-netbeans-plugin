namespace :gherkin do

  require 'lib/gherkin'
  require 'lib/project_xml'

  desc 'List Available Versions'
  task :available_versions do
    puts Gherkin.available_versions
  end

  desc 'Show Latest Available Version'
  task :latest_version do
    puts Gherkin.latest_version
  end

  desc 'Show Current Jar Version'
  task :jar_version do
    puts Gherkin.jar_version
  end

  desc 'Show Current Gem Version'
  task :gem_version do
    puts Gherkin.gem_version
  end

  desc 'Check for Updates'
  task :update_check do
    Gherkin.update_check
  end

  desc 'Update Current Jar: Download File and Change Project Settings'
  task :update_jar do
    require 'lib/gherkin'
    latest_available_version = Gherkin.latest_version
    gem_version = Gherkin.gem_version
    jar_version = Gherkin.jar_version

    if Gherkin.update_available?
      Gherkin.download_jar(latest_available_version)
      ProjectXml.update_jar_version(jar_version, latest_available_version)
      Gherkin.delete_jar(jar_version)
    else
      puts "--> No Updates are available."
    end
  end

  desc 'Update Gherkin Gem'
  task :update_gem do
    system "gem update gherkin"
    system "gem cleanup gherkin"
  end

end
