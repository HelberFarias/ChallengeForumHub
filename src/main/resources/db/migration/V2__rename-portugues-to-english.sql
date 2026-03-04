ALTER TABLE topicos RENAME TO topics;

ALTER TABLE topics RENAME COLUMN titulo TO title;
ALTER TABLE topics RENAME COLUMN mensagem TO message;
ALTER TABLE topics RENAME COLUMN data_criacao TO created_at;
ALTER TABLE topics RENAME COLUMN estado TO status;
ALTER TABLE topics RENAME COLUMN autor_id TO author_id;
ALTER TABLE topics RENAME COLUMN curso_id TO course_id;