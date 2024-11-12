`mvn clean test -Dsurefire.suiteXmlFiles=src/test/smokeTestOMS.xml`

`mvn clean test "-Dsurefire.suiteXmlFiles=src/test/smokeTestPMS.xml" "-DtestingUrl=https://dev-admin.onpoint.vn"`

`allure generate allure-results --clean`

##remove allure report##
`rm -rf allure-re*`

`mvn test -D suite=smokeTestOMS.xml`