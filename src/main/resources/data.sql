INSERT INTO USER_INFO(user_name, password, role, create_time)
SELECT 'admin', 'admin', 'admin', CURRENT_TIMESTAMP()
WHERE NOT EXISTS (SELECT USER_NAME FROM USER_INFO WHERE USER_NAME = 'admin');