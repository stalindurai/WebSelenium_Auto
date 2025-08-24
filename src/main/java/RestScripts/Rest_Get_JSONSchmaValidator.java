package RestScripts;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class Rest_Get_JSONSchmaValidator {

    @Test
    public void getIncident(){

        String schema = """
                {
                   "$schema": "http://json-schema.org/draft-07/schema#",
                   "title": "Generated schema for Root",
                   "type": "object",
                   "properties": {
                     "result": {
                       "type": "array",
                       "items": {
                         "type": "object",
                         "properties": {
                           "parent": {
                             "type": "string"
                           },
                           "made_sla": {
                             "type": "string"
                           },
                           "caused_by": {
                             "type": "string"
                           },
                           "watch_list": {
                             "type": "string"
                           },
                           "upon_reject": {
                             "type": "string"
                           },
                           "sys_updated_on": {
                             "type": "string"
                           },
                           "child_incidents": {
                             "type": "string"
                           },
                           "hold_reason": {
                             "type": "string"
                           },
                           "origin_table": {
                             "type": "string"
                           },
                           "task_effective_number": {
                             "type": "string"
                           },
                           "approval_history": {
                             "type": "string"
                           },
                           "number": {
                             "type": "string"
                           },
                           "resolved_by": {},
                           "sys_updated_by": {
                             "type": "string"
                           },
                           "opened_by": {
                             "type": "object",
                             "properties": {
                               "link": {
                                 "type": "string"
                               },
                               "value": {
                                 "type": "string"
                               }
                             },
                             "required": [
                               "link",
                               "value"
                             ]
                           },
                           "user_input": {
                             "type": "string"
                           },
                           "sys_created_on": {
                             "type": "string"
                           },
                           "sys_domain": {
                             "type": "object",
                             "properties": {
                               "link": {
                                 "type": "string"
                               },
                               "value": {
                                 "type": "string"
                               }
                             },
                             "required": [
                               "link",
                               "value"
                             ]
                           },
                           "state": {
                             "type": "string"
                           },
                           "route_reason": {
                             "type": "string"
                           },
                           "sys_created_by": {
                             "type": "string"
                           },
                           "knowledge": {
                             "type": "string"
                           },
                           "order": {
                             "type": "string"
                           },
                           "calendar_stc": {
                             "type": "string"
                           },
                           "closed_at": {
                             "type": "string"
                           },
                           "cmdb_ci": {},
                           "delivery_plan": {
                             "type": "string"
                           },
                           "contract": {
                             "type": "string"
                           },
                           "impact": {
                             "type": "string"
                           },
                           "active": {
                             "type": "string"
                           },
                           "work_notes_list": {
                             "type": "string"
                           },
                           "business_service": {},
                           "business_impact": {
                             "type": "string"
                           },
                           "priority": {
                             "type": "string"
                           },
                           "sys_domain_path": {
                             "type": "string"
                           },
                           "rfc": {
                             "type": "string"
                           },
                           "time_worked": {
                             "type": "string"
                           },
                           "expected_start": {
                             "type": "string"
                           },
                           "opened_at": {
                             "type": "string"
                           },
                           "business_duration": {
                             "type": "string"
                           },
                           "group_list": {
                             "type": "string"
                           },
                           "work_end": {
                             "type": "string"
                           },
                           "caller_id": {
                             "type": "object",
                             "properties": {
                               "link": {
                                 "type": "string"
                               },
                               "value": {
                                 "type": "string"
                               }
                             },
                             "required": [
                               "link",
                               "value"
                             ]
                           },
                           "reopened_time": {
                             "type": "string"
                           },
                           "resolved_at": {
                             "type": "string"
                           },
                           "approval_set": {
                             "type": "string"
                           },
                           "subcategory": {
                             "type": "string"
                           },
                           "work_notes": {
                             "type": "string"
                           },
                           "universal_request": {
                             "type": "string"
                           },
                           "short_description": {
                             "type": "string"
                           },
                           "close_code": {
                             "type": "string"
                           },
                           "correlation_display": {
                             "type": "string"
                           },
                           "delivery_task": {
                             "type": "string"
                           },
                           "work_start": {
                             "type": "string"
                           },
                           "assignment_group": {},
                           "additional_assignee_list": {
                             "type": "string"
                           },
                           "business_stc": {
                             "type": "string"
                           },
                           "cause": {
                             "type": "string"
                           },
                           "description": {
                             "type": "string"
                           },
                           "origin_id": {
                             "type": "string"
                           },
                           "calendar_duration": {
                             "type": "string"
                           },
                           "close_notes": {
                             "type": "string"
                           },
                           "notify": {
                             "type": "string"
                           },
                           "service_offering": {
                             "type": "string"
                           },
                           "sys_class_name": {
                             "type": "string"
                           },
                           "closed_by": {},
                           "follow_up": {
                             "type": "string"
                           },
                           "parent_incident": {},
                           "sys_id": {
                             "type": "string"
                           },
                           "contact_type": {
                             "type": "string"
                           },
                           "reopened_by": {
                             "type": "string"
                           },
                           "incident_state": {
                             "type": "string"
                           },
                           "urgency": {
                             "type": "string"
                           },
                           "problem_id": {},
                           "company": {},
                           "reassignment_count": {
                             "type": "string"
                           },
                           "activity_due": {
                             "type": "string"
                           },
                           "assigned_to": {},
                           "severity": {
                             "type": "string"
                           },
                           "comments": {
                             "type": "string"
                           },
                           "approval": {
                             "type": "string"
                           },
                           "sla_due": {
                             "type": "string"
                           },
                           "comments_and_work_notes": {
                             "type": "string"
                           },
                           "due_date": {
                             "type": "string"
                           },
                           "sys_mod_count": {
                             "type": "string"
                           },
                           "reopen_count": {
                             "type": "string"
                           },
                           "sys_tags": {
                             "type": "string"
                           },
                           "escalation": {
                             "type": "string"
                           },
                           "upon_approval": {
                             "type": "string"
                           },
                           "correlation_id": {
                             "type": "string"
                           },
                           "location": {},
                           "category": {
                             "type": "string"
                           }
                         },
                         "required": [
                           "parent",
                           "made_sla",
                           "caused_by",
                           "watch_list",
                           "upon_reject",
                           "sys_updated_on",
                           "child_incidents",
                           "hold_reason",
                           "origin_table",
                           "task_effective_number",
                           "approval_history",
                           "number",
                           "resolved_by",
                           "sys_updated_by",
                           "opened_by",
                           "user_input",
                           "sys_created_on",
                           "sys_domain",
                           "state",
                           "route_reason",
                           "sys_created_by",
                           "knowledge",
                           "order",
                           "calendar_stc",
                           "closed_at",
                           "cmdb_ci",
                           "delivery_plan",
                           "contract",
                           "impact",
                           "active",
                           "work_notes_list",
                           "business_service",
                           "business_impact",
                           "priority",
                           "sys_domain_path",
                           "rfc",
                           "time_worked",
                           "expected_start",
                           "opened_at",
                           "business_duration",
                           "group_list",
                           "work_end",
                           "caller_id",
                           "reopened_time",
                           "resolved_at",
                           "approval_set",
                           "subcategory",
                           "work_notes",
                           "universal_request",
                           "short_description",
                           "close_code",
                           "correlation_display",
                           "delivery_task",
                           "work_start",
                           "assignment_group",
                           "additional_assignee_list",
                           "business_stc",
                           "cause",
                           "description",
                           "origin_id",
                           "calendar_duration",
                           "close_notes",
                           "notify",
                           "service_offering",
                           "sys_class_name",
                           "closed_by",
                           "follow_up",
                           "parent_incident",
                           "sys_id",
                           "contact_type",
                           "reopened_by",
                           "incident_state",
                           "urgency",
                           "problem_id",
                           "company",
                           "reassignment_count",
                           "activity_due",
                           "assigned_to",
                           "severity",
                           "comments",
                           "approval",
                           "sla_due",
                           "comments_and_work_notes",
                           "due_date",
                           "sys_mod_count",
                           "reopen_count",
                           "sys_tags",
                           "escalation",
                           "upon_approval",
                           "correlation_id",
                           "location",
                           "category"
                         ]
                       }
                     }
                   },
                   "required": [
                     "result"
                   ]
                 }    
                       """;
        String res =
        RestAssured.given()
                .baseUri("https://dev229753.service-now.com")
                .basePath("/api/now/table")
                .auth().basic("admin", "t*LwMr/FaI52")
                .queryParam("sysparm_limit","3")
//                .queryParam("sysparm_fields", "sys_id,short_description,number,description,state")
                .log().all()
                .when()
                .get("/incident")
                .then().log().all()
                .body(JsonSchemaValidator.matchesJsonSchema(schema))
                .assertThat().statusCode(200).toString();

        System.out.println(res);

    }

}

/*sys_id
* short_description
* number
* description
* state
* */
