-- Skills
INSERT INTO skill (skill_name) VALUES ('ReactJS');
INSERT INTO skill (skill_name) VALUES ('NodeJS');
INSERT INTO skill (skill_name) VALUES ('Flutter');
INSERT INTO skill (skill_name) VALUES ('Java');
INSERT INTO skill (skill_name) VALUES ('Springboot');
INSERT INTO skill (skill_name) VALUES ('Python');
INSERT INTO skill (skill_name) VALUES ('Django');

-- Resources
INSERT INTO resource (resource_name) VALUES ('Alice');
INSERT INTO resource (resource_name) VALUES ('Bob');
INSERT INTO resource (resource_name) VALUES ('Ravi');
INSERT INTO resource (resource_name) VALUES ('Prashanth');

-- Resource-Skill mapping
INSERT INTO resource_skill (resource_id, skill_id) VALUES (1, 1); -- Alice -> ReactJS
INSERT INTO resource_skill (resource_id, skill_id) VALUES (1, 2); -- Alice -> NodeJS
INSERT INTO resource_skill (resource_id, skill_id) VALUES (2, 3); -- Bob -> Flutter
INSERT INTO resource_skill (resource_id, skill_id) VALUES (2, 1); -- Bob -> ReactJS
INSERT INTO resource_skill (resource_id, skill_id) VALUES (3, 4); -- Alice -> ReactJS
INSERT INTO resource_skill (resource_id, skill_id) VALUES (3, 5); -- Alice -> NodeJS
INSERT INTO resource_skill (resource_id, skill_id) VALUES (4,6); -- Bob -> Flutter
INSERT INTO resource_skill (resource_id, skill_id) VALUES (4, 6); -- Bob -> ReactJS


-- Projects
INSERT INTO project (project_name, start_date, end_date) VALUES ('Project A', '2024-08-01', '2024-10-01');
INSERT INTO project (project_name, start_date, end_date) VALUES ('Project B', '2024-09-01', '2024-12-01');

-- Tasks
-- Tasks for Project A
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Frontend Development', '2024-08-15', '2024-09-15', 1, 1); -- ReactJS
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Backend Development', '2024-08-15', '2024-10-15', 2, 1); -- NodeJS
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('API Integration', '2024-09-10', '2024-10-10', 3, 1); -- Flutter

-- Tasks for Project B
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('UI Testing', '2024-08-15', '2024-09-15', 1, 2); -- ReactJS
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Database Migration', '2024-09-01', '2024-09-30', 2, 2); -- NodeJS
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Feature A', '2024-09-01', '2024-09-15', 4, 2); -- Java
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Feature B', '2024-09-10', '2024-09-20', 4, 2); -- Java
INSERT INTO task (task_name, start_date, end_date, skill_id, project_id)
VALUES ('Security Patch', '2024-09-01', '2024-09-15', 6, 2); -- Python