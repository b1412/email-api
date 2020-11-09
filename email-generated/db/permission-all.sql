INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (1,0,'Index EmailLog','/v[\\d]+/email-log','EmailLog','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (2,0,'Create EmailLog','/v[\\d]+/email-log','EmailLog','POST',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (3,0,'Read EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (4,0,'Update EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','PUT',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (5,0,'Delete a EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (6,0,'Delete all EmailLog','/v[\\d]+/email-log/clear','EmailLog','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (7,0,'Excel EmailLog','/v[\\d]+/email-log/excel','EmailLog','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (1,0,'Index EmailServer','/v[\\d]+/email-server','EmailServer','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (2,0,'Create EmailServer','/v[\\d]+/email-server','EmailServer','POST',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (3,0,'Read EmailServer','/v[\\d]+/email-server/[\\d]+','EmailServer','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (4,0,'Update EmailServer','/v[\\d]+/email-server/[\\d]+','EmailServer','PUT',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (5,0,'Delete a EmailServer','/v[\\d]+/email-server/[\\d]+','EmailServer','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (6,0,'Delete all EmailServer','/v[\\d]+/email-server/clear','EmailServer','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (7,0,'Excel EmailServer','/v[\\d]+/email-server/excel','EmailServer','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (1,0,'Index EmailTemplate','/v[\\d]+/email-template','EmailTemplate','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (2,0,'Create EmailTemplate','/v[\\d]+/email-template','EmailTemplate','POST',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (3,0,'Read EmailTemplate','/v[\\d]+/email-template/[\\d]+','EmailTemplate','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (4,0,'Update EmailTemplate','/v[\\d]+/email-template/[\\d]+','EmailTemplate','PUT',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (5,0,'Delete a EmailTemplate','/v[\\d]+/email-template/[\\d]+','EmailTemplate','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (6,0,'Delete all EmailTemplate','/v[\\d]+/email-template/clear','EmailTemplate','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (7,0,'Excel EmailTemplate','/v[\\d]+/email-template/excel','EmailTemplate','GET',1, 1);



INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (11, 0, 1, 1, 1, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (12, 0, 1, 1, 2, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (13, 0, 1, 1, 3, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (14, 0, 1, 1, 4, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (15, 0, 1, 1, 5, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (16, 0, 1, 1, 6, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (17, 0, 1, 1, 7, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (31, 0, 1, 1, 1, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (32, 0, 1, 1, 2, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (33, 0, 1, 1, 3, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (34, 0, 1, 1, 4, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (35, 0, 1, 1, 5, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (36, 0, 1, 1, 6, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (37, 0, 1, 1, 7, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (11, 0, 1, 1, 1, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (12, 0, 1, 1, 2, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (13, 0, 1, 1, 3, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (14, 0, 1, 1, 4, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (15, 0, 1, 1, 5, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (16, 0, 1, 1, 6, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (17, 0, 1, 1, 7, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (31, 0, 1, 1, 1, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (32, 0, 1, 1, 2, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (33, 0, 1, 1, 3, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (34, 0, 1, 1, 4, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (35, 0, 1, 1, 5, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (36, 0, 1, 1, 6, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (37, 0, 1, 1, 7, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (11, 0, 1, 1, 1, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (12, 0, 1, 1, 2, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (13, 0, 1, 1, 3, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (14, 0, 1, 1, 4, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (15, 0, 1, 1, 5, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (16, 0, 1, 1, 6, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (17, 0, 1, 1, 7, 1);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (31, 0, 1, 1, 1, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (32, 0, 1, 1, 2, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (33, 0, 1, 1, 3, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (34, 0, 1, 1, 4, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (35, 0, 1, 1, 5, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (36, 0, 1, 1, 6, 3);
INSERT INTO role_permission (id, version, creator_id, modifier_id, permission_id, role_id)
VALUES (37, 0, 1, 1, 7, 3);



INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (11, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (12, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (13, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (14, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (15, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (16, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (17, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (11, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (12, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (13, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (14, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (15, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (16, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (17, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (11, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (12, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (13, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (14, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (15, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (16, 1);
INSERT INTO role_permission_rule (role_permission_id, rule_id)
VALUES (17, 1);
