INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('GET_TASK', 'get task info by id', 1, '/system/task/{id}', 'GET', 160, 'TASK_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('GET_TASKS', 'search tasks', 1, '/system/task', 'GET', 150, 'TASK_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('GET_USER', 'get user info by id', 1, '/system/user/{id}', 'GET', 260, 'USER_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('GET_USERS', 'search users', 1, '/system/user', 'GET', 250, 'USER_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('MOD_TASK', 'modify task', 1, '/system/task', 'PUT', 130, 'TASK_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('MOD_USER', 'modify user', 1, '/system/user', 'PUT', 230, 'USER_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('NEW_TASK', 'create task', 1, '/system/task', 'POST', 110, 'TASK_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('NEW_USER', 'create user', 1, '/system/user', 'POST', 210, 'USER_GROUP', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('ROOT', 'ROOT', 0, '', '', 0, '', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('TASK_GROUP', 'Task Group', 0, '', '', 100, 'ROOT', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('USER_GROUP', 'User Group', 0, '', '', 200, 'ROOT', '2018-05-16 23:58:15', null);
INSERT INTO lynk_sys.SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES ('GET_USER_PERMISSIONS', 'get user permissions by id', 1, '/system/user/{id}/permissions', 'GET', 260, 'USER_GROUP', NOW(), NULL);