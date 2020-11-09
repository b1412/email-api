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
