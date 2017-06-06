node {
   stage ('git clone'){
   git 'https://github.com/mizo432/CleanArchitecture.git'
   }

   stage( 'clean'){
   sh './gradlew clean'
   }

   stage( 'build'){
    sh './gradlew :utils:build --daemon'
    sh './gradlew :application-model:build --daemon'
    sh './gradlew :commons:build --daemon'
    sh './gradlew :contracts:build --daemon'
    sh './gradlew :mybatis-repository:build --daemon'
    sh './gradlew :use-cases:build --daemon'
   }

// JUnitテストレポートを保存
//   step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/*.xml'])

   stage ('create reports'){
   sh './gradlew jacocoTestReport --daemon'

   sh './gradlew jdepend --daemon'

   sh './gradlew findbugsMain --daemon'

   }

   stage('assembles reports'){
        jacoco exclusionPattern: '**/*Test*.class'
        openTasks canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', high: 'FIXME', ignoreCase: true, low: 'XXX', normal: 'TODO', pattern: '**/*.java', unHealthy: ''
        findbugs canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', pattern: '**/build/reports/findbugs/*.xml', unHealthy: ''
        warnings canComputeNew: false, canResolveRelativePaths: false, consoleParsers: [[parserName: 'Java Compiler (javac)'], [parserName: 'JavaDoc Tool']], defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', messagesPattern: '', unHealthy: ''
   }

}