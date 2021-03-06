INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10201,0,'Index EmailLog','/v[\\d]+/email-log','EmailLog','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10202,0,'Create EmailLog','/v[\\d]+/email-log','EmailLog','POST',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10203,0,'Read EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10204,0,'Update EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','PUT',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10205,0,'Delete a EmailLog','/v[\\d]+/email-log/[\\d]+','EmailLog','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10206,0,'Delete all EmailLog','/v[\\d]+/email-log/clear','EmailLog','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10207,0,'Excel EmailLog','/v[\\d]+/email-log/excel','EmailLog','GET',1, 1);
