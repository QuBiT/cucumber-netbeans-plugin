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

