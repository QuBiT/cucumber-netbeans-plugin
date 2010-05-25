import 'lib/tasks/i18n/feature_nbs.rake'
import 'lib/tasks/i18n/templates.rake'
import 'lib/tasks/i18n/bundle_properties.rake'
import 'lib/tasks/i18n/layer_xml.rake'
import 'lib/tasks/i18n/gherkin.rake'

namespace :i18n do

  desc "Generate NBS-Language-File"
  task :generate => [:generate_feature_nbs_file]

  desc "Update Gherkin"
  task :update_gherkin => [:update_gherkin_gem, :update_gherkin_jar]

  desc "Update Templates"
  task :update_templates => [:recreate_templates_from_github, :update_bundle_properties, :update_layer_xml_file]

end

