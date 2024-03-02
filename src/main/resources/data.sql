INSERT INTO landlord (name) VALUES
    ('Bruce Wayne'),
    ('Clark Kent');

INSERT INTO tenant (name) VALUES
    ('Jack Bauer'),
    ('John Wick');

INSERT INTO property (landlord_id, name, unit_price, surface, description) VALUES
    (1, 'Bydgoszcz ul. Rataja 8', 40.0, 42, 'Oferuje na wynajem mieszkanie 2-pokojowe o powierzchni uzytkowej 48m kw., w Bydgoszczy przy ul. Rataja 8 (Fordon, os. Szybownikow). Mieszkanie na 3 pietrze w 4 pietrowym budynku, blok ocieplony z zewnatrz, wyremontowana klatka schodowa. Lokalizacja spokojna na uboczu osiedla. Duza ilosc miejsc parkingowych wokol bloku.'),
    (2, 'Bialystok ul. Depowej 9G', 20, 25, 'Wynajme 2 - pokojowe mieszkanie o pow. 35 m2 przy ul. Depowej 9G w Bialymstoku. Mieszkanie sklada sie z salonu z aneksem kuchennym i wyjsciem na obszerny balkon, oddzielnej lazienki oraz sypialni. Mieszkanie jest umeblowane i wyposazone w sprzet AGD - pralka, lodowka, piekarnik z mikrofala, plyta indukcyjna, zmywarka. Mieszkanie jest wyposazone takze w klimatyzacje oraz TV (50 cali) . Mieszkanie dla osob niepalacych, bez zwierzat. Mieszkanie znajduje sie na 3. pietrze (jest winda). Czynsz wynosi 1800 zl plus ok 500 zl oplat (czynsz na rzecz wspolnoty, prad oraz internet). Lokal dostepny od reki Kaucja zwrotna 3000zl.');

INSERT INTO reservation (landlord_id, tenant_id, property_id, rent_start, rent_end, cost) VALUES
    (1, 1, 1, '2018-10-20', '2018-10-20', 40),
    (1, 1, 1, '2018-10-20', '2018-10-20', 40);
