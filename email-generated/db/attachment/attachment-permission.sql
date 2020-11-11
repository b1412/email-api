INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10101,0,'Index Attachment','/v[\\d]+/attachment','Attachment','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10102,0,'Create Attachment','/v[\\d]+/attachment','Attachment','POST',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10103,0,'Read Attachment','/v[\\d]+/attachment/[\\d]+','Attachment','GET',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10104,0,'Update Attachment','/v[\\d]+/attachment/[\\d]+','Attachment','PUT',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10105,0,'Delete a Attachment','/v[\\d]+/attachment/[\\d]+','Attachment','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10106,0,'Delete all Attachment','/v[\\d]+/attachment/clear','Attachment','DELETE',1, 1);
INSERT INTO permission (id, version, auth_key, auth_uris, entity, http_method, creator_id, modifier_id)
VALUES (10107,0,'Excel Attachment','/v[\\d]+/attachment/excel','Attachment','GET',1, 1);
