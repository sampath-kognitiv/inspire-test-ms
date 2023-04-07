CREATE TABLE IF NOT EXISTS currency (
  id SERIAL PRIMARY KEY,
  ref VARCHAR,
  name VARCHAR,
  short_name VARCHAR,
  ext boolean DEFAULT false,
  UNIQUE(ref)
);

insert into currency(ref,name,short_name)
values('miles', 'Air Miles', 'Miles'),
('gold', 'Gold Coins', 'Gold'),
('swag', 'Swag Tokens', 'Swag Tokens');
