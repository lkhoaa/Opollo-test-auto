`mvn clean test -Dsurefire.suiteXmlFiles=/path/to/testSuiteLocation.xml`

`mvn clean test "-Dsurefire.suiteXmlFiles=src/test/testCreateB2B.xml" "-DtestingUrl=https://dev-admin.onpoint.vn"`

`allure generate allure-results --clean`

##remove allure report##

`rm -rf allure-re*`