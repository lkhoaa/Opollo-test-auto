`mvn clean test "-Dsurefire.suiteXmlFiles=src/test/testCasePOMS.xml" "-DtestingUrl=https://dev-admin.onpoint.vn"`

cd Opollo -> `allure generate allure-results --clean -o allure-report`

##remove allure report##
cd Opollo -> `rm -rf allure-re*`