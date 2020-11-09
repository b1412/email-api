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
