$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/praveendas/Downloads/Undostres/UndostresWebAutomation1/src/main/resources/features/mobileRecharge/mobileRecharge_cc.feature");
formatter.feature({
  "line": 1,
  "name": "Mobile recharge Automation on UNDOSTRES web Application",
  "description": "Description: This is a demo test, to do a mobile recharge",
  "id": "mobile-recharge-automation-on-undostres-web-application",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "",
  "description": "Verify a user should able to do mobile recharge by a given credit card",
  "id": "mobile-recharge-automation-on-undostres-web-application;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@QA_TEST"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "The test execution is running on \"\u003cEnvironment\u003e\"",
  "keyword": "Given "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "mobile-recharge-automation-on-undostres-web-application;;",
  "rows": [
    {
      "cells": [
        "Environment",
        "Amount",
        "cardNumber"
      ],
      "line": 11,
      "id": "mobile-recharge-automation-on-undostres-web-application;;;1"
    },
    {
      "cells": [
        "QA",
        "10",
        "4111111111111111"
      ],
      "line": 12,
      "id": "mobile-recharge-automation-on-undostres-web-application;;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2895275600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "",
  "description": "Verify a user should able to do mobile recharge by a given credit card",
  "id": "mobile-recharge-automation-on-undostres-web-application;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@QA_TEST"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "The test execution is running on \"QA\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "QA",
      "offset": 34
    }
  ],
  "location": "StepDef_undostres_mobileReacharge.the_test_execution_is_running_on(String)"
});
formatter.result({
  "duration": 41770600,
  "error_message": "java.lang.ExceptionInInitializerError\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.setupConverters(XStream.java:820)\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:574)\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:530)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams$LocalizedXStream.\u003cinit\u003e(LocalizedXStreams.java:50)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams.newXStream(LocalizedXStreams.java:37)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams.get(LocalizedXStreams.java:29)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.runtime.Runtime.run(Runtime.java:122)\r\n\tat cucumber.api.cli.Main.run(Main.java:36)\r\n\tat cucumber.api.cli.Main.main(Main.java:18)\r\n\tat ✽.Given The test execution is running on \"QA\"(C:/Users/praveendas/Downloads/Undostres/UndostresWebAutomation1/src/main/resources/features/mobileRecharge/mobileRecharge_cc.feature:7)\r\nCaused by: java.lang.reflect.InaccessibleObjectException: Unable to make field private final java.util.Comparator java.util.TreeMap.comparator accessible: module java.base does not \"opens java.util\" to unnamed module @39aeed2f\r\n\tat java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:357)\r\n\tat java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)\r\n\tat java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:177)\r\n\tat java.base/java.lang.reflect.Field.setAccessible(Field.java:171)\r\n\tat cucumber.deps.com.thoughtworks.xstream.core.util.Fields.locate(Fields.java:39)\r\n\tat cucumber.deps.com.thoughtworks.xstream.converters.collections.TreeMapConverter.\u003cclinit\u003e(TreeMapConverter.java:50)\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.setupConverters(XStream.java:820)\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:574)\r\n\tat cucumber.deps.com.thoughtworks.xstream.XStream.\u003cinit\u003e(XStream.java:530)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams$LocalizedXStream.\u003cinit\u003e(LocalizedXStreams.java:50)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams.newXStream(LocalizedXStreams.java:37)\r\n\tat cucumber.runtime.xstream.LocalizedXStreams.get(LocalizedXStreams.java:29)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.runtime.Runtime.run(Runtime.java:122)\r\n\tat cucumber.api.cli.Main.run(Main.java:36)\r\n\tat cucumber.api.cli.Main.main(Main.java:18)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 89861000,
  "status": "passed"
});
});