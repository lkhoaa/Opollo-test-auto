## Quick Setup and Test Execution

This repository is a dual-purpose automation platform with Selenium test automation and financial data validation capabilities. Here's how to set it up and run tests:

### Prerequisites and Setup

**Required Dependencies:**
- Java 18
- Maven (configured with Surefire plugin)
- Chrome/Chromium browser

**Key Dependencies in `pom.xml`:**
- Selenium WebDriver 3.141.59
- TestNG 7.7.0
- Allure Framework 2.13.9

### Running Tests

**1. Automated CI/CD Execution:**
Tests automatically run on push to main branch via GitHub Actions

**2. Manual Local Execution:**
```bash
cd Opollo
mvn clean test -Dsurefire.suiteXmlFiles=src/test/testCreatePOMS.xml -DtestingUrl=https://dev-admin.onpoint.vn
```

### Test Structure

**Primary Test Case:** `CreatePO6Steps` validates Purchase Order creation workflow

The test performs:
1. Login to dev-admin.onpoint.vn
2. Navigate to PO creation page
3. Fill form and submit PO
4. Verify step visibility

### Report Generation

Allure reports are automatically generated and deployed to GitHub Pages

**Notes**

The repository also contains financial data validation tests for comparing fees across platforms (TikTok, Shopee, etc.). The WebDriver setup uses ChromeDriver with proper configuration for CI/CD environments.
