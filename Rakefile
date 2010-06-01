import 'lib/tasks/i18n/feature_nbs.rake'
import 'lib/tasks/i18n/templates.rake'
import 'lib/tasks/i18n/bundle_properties.rake'
import 'lib/tasks/i18n/layer_xml.rake'
import 'lib/tasks/i18n/gherkin.rake'

namespace :i18n do
  # For more details see lib/tasks/i18n/feature_nbs.rake
  desc "Generate NBS-Language-File"
  task :generate => [:generate_feature_nbs_file]
end

namespace :gherkin do
  # For more details see lib/tasks/i18n/gherkin.rake
  desc "Update Gherkin (Gem & Jar Update)"
  task :update => [:update_gem, :update_jar]
end

namespace :templates do
  # For more details see lib/tasks/i18n/templates.rake
  desc "Update Templates (Recreate Files, Update Bundle.properties and layer.xml)"
  task :update => [:recreate_from_github, :update_bundle_properties, :update_layer_xml_file]
end

# use jeweler for versioning
begin
  require 'jeweler'
  require 'yaml'
  Jeweler::Tasks.new do |gemspec|
    gemspec.name = "cucumber-features"
    gemspec.summary = "dummy spec to access jeweler's rake tasks"
    gemspec.description = "this is only used to get access to the rake tasks of jeweler"
    gemspec.homepage = "http://github.com/QuBiT/cucumber-netbeans-plugin"
    gemspec.authors = ["Roland Guem"]
  end
rescue LoadError
  puts "Jeweler not available. Install it with: gem install jeweler"
end

# remove unnecessary jeweler tasks.
Rake::TaskManager.class_eval do
  def remove_task(task_name)
    @tasks.delete(task_name.to_s)
  end
end
array = ['check_dependencies','check_dependencies:development','check_dependencies:runtime']
array << ['build','release', 'install', 'git:release', 'github:release', 'gemspec', 'gemspec:debug', 'gemspec:generate', 'gemspec:validate']
array.flatten.each do |task_name|
  Rake.application.remove_task task_name
end
