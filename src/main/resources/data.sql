insert into article (created_at, modified_at, created_by, modified_by, content, hashtag, title)
values ('1111-11-11', '1111-11-11', '1', '2', 'content1', '#spring', 'title1');

insert into article_comment (article_id, created_at, modified_at, created_by, modifed_by, content)
values (1, '1111-11-11', '1111-11-11', '1', '2', 'content1'),
       (1, '1111-11-11', '1111-11-11', '1', '2', 'content2');