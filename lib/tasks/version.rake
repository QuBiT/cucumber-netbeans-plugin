namespace :version do

  require 'lib/manifest_mf'
  require 'lib/project_properties'

  desc 'Whenever you bump a VERSION, then you also have to run this task to update the project.'
  task :update => [:manifest_update, :project_properties_update]

  desc "Update the Manifest"
  task :manifest_update do
    vh = Jeweler::VersionHelper.new(".")
    ManifestMf.update_patch_version(vh.patch)
  end

  desc "Update the Project Properties"
  task :project_properties_update do
    vh = Jeweler::VersionHelper.new(".")
    ProjectProperties.update_version(vh.major, vh.minor)
  end

end