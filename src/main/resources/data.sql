INSERT INTO landlord (name) VALUES
    ('Bruce Wayne'),
    ('Clark Kent');

INSERT INTO tenant (name) VALUES
    ('Jack Bauer'),
    ('John Wick');

INSERT INTO property (landlord_id, name, unit_price, surface, description) VALUES
    (1, 'Dom nad jeziorem', 150.0, 150, 'Przestronny dom z widokiem na jezioro.'),
    (2, 'Apartament w centrum', 200, 100, 'Nowoczesny apartament w sercu miasta.');

INSERT INTO reservation (landlord_id, tenant_id, property_id, rent_start, rent_end, cost, guests) VALUES
    (1, 1, 1, '2018-10-1', '2018-10-5', 40, 6),
    (1, 2, 1, '2018-10-7', '2018-10-12', 40, 8),
    (1, 2, 2, '2018-10-17', '2018-10-18', 40, 4),
    (1, 1, 1, '2018-10-22', '2018-10-29', 40, 12);



