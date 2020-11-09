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
