`mvn clean test -Dsurefire.suiteXmlFiles=/path/to/testSuiteLocation.xml`

`mvn clean test "-Dsurefire.suiteXmlFiles=src/test/testCreatePOMS.xml" "-DtestingUrl=https://dev-admin.onpoint.vn"`

`allure generate allure-results --clean`

##remove allure report##
`rm -rf allure-re*`

`mvn test -D suite=testCreateB2B.xml`