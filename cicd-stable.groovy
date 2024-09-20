node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/cjsonport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/cjsonport.git'), string(name: 'PORT_DESCRIPTION', value: 'Ultralightweight JSON parser in ANSI C' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
