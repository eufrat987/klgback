INSERT INTO landlord (name) VALUES
    ('Bruce Wayne'),
    ('Clark Kent');

INSERT INTO tenant (name) VALUES
    ('Jack Bauer'),
    ('John Wick');

INSERT INTO property (name, unit_price, surface, description) VALUES
    ('Dom nad jeziorem', 150.0, 150, 'Przestronny dom z widokiem na jezioro.'),
    ('Apartament w centrum', 200, 100, 'Nowoczesny apartament w sercu miasta.');

INSERT INTO reservation (landlord, tenant, property, rent_start, rent_end, cost, guests) VALUES
    ('Bruce Wayne', 'Jack Bauer',   'Dom nad jeziorem',     '2018-10-1',    '2018-10-5',    40, 6),
    ('Bruce Wayne', 'John Wick',    'Dom nad jeziorem',     '2018-10-7',    '2018-10-12',   40, 8),
    ('Bruce Wayne', 'John Wick',    'Apartament w centrum', '2018-10-17',   '2018-10-18',   40, 4),
    ('Bruce Wayne', 'Jack Bauer',   'Dom nad jeziorem',     '2018-10-22',   '2018-10-29',   40, 12),
    ('Bruce Wayne', 'Jack Bauer',   'Dom nad jeziorem',     '2018-11-1',    '2018-11-5',    70, 7);



