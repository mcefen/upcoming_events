INSERT INTO user (name, password1, role) VALUES
  ('sidi', '111111', 'admin'),
  ('maria', '222222', 'admin'),
  ('dulce', '333333', 'admin'),
  ('brian', '444444', 'admin'),
  ('pablo', '555555', 'admin'),
  ('antoni', '666666', 'admin'),
  ('txema', '123456', 'admin');


INSERT INTO games (name, abbreviation) VALUES
('Call of Duty', 'COD'),
('Call of Duty 2', 'COD 2'),
('Call of Duty 3', 'COD 3'),
('Call of Duty 4: Modern Warfare', 'COD MW'),
('League of Legends', 'LOL'),
('Defense of the Ancients 2', 'DOTA 2'),
('StarCraft 2', 'StarCraft 2'), 
('Splatoon', 'Splatoon'),
('Mario Kart 8 Deluxe', 'MK 8'),
('Fortnite', 'Fortnite'),
('Apex Legends', 'Apex'),
('Overwatch 2', 'OW 2');


INSERT INTO eventgames  (title, publicationevent, participants, limitparticipants, description, image, availability, id_game, id_user) VALUES
('COD tournament', '2023-08-01', '', '100', 'Torneo abierto de Call of Duty. Este torneo será eliminatorio y se realizará por equipos de cinco personas. El limite de participantes es de 100 jugadores. La fecha de inscripción se deberá realizar unos cinco días antes.', ' ', 'yes', '1', '1'),
('COD tournament 2', '2023-09-26', '', '150', 'Torneo cerrado de Call of Duty. Este torneo será eliminatorio y se realizará por equipos de diez personas. El limite de participantes es de 150 jugadores. La fecha de inscripción se deberá realizar unos cinco días antes.', ' ', 'yes', '1', '2'),
('LOL tournament', '2023-12-09', '', '50', 'Torneo abierto de League of legends. Este torneo será eliminatorio y se realizará por equipos de cinco personas. El limite de participantes es de 50 jugadores. La fecha de inscripción se deberá realizar unos siete días antes.', ' ', 'yes', '5', '3'),
('DOTA 2 tournament', '2023-05-18', '', '110', 'Torneo abierto de DOTA 2. Este torneo será eliminatorio y se realizará por equipos de diez personas. El limite de participantes es de 110 jugadores. La fecha de inscripción se deberá realizar unos cinco días antes.',' ', 'no', '6', '4'),
('Starcraft 2 tournament', '2023-01-20', '', '120', 'Torneo abierto de Starcraft 2. Este torneo será eliminatorio y se realizará por dos equipos, teniendo cada uno un unico jugador. El limite de participantes es de 120 jugadores. La fecha de inscripción se deberá realizar unos cinco días antes.', 'no', '7', '5'),
('Splatoon tournament', '2023-11-03', '', '200', 'Torneo abierto de Splatoon. Este torneo será eliminatorio y se realizará por equipos de cinco personas. El limite de participantes es de 200 jugadores. La fecha de inscripción se deberá realizar unos veinte días antes.',' ', 'yes', '8', '6'),
('Mario Kart 8 tournament', '2023-12-05', '', '250', 'Torneo abierto de Mario Kart 8 Deluxe. Este torneo será eliminatorio y se realizará por equipos de seis personas. El limite de participantes es de 250 jugadores. La fecha de inscripción se deberá realizar unos tres días antes.', ' ', 'yes', '9', '7'),
('Fortnite tournament', '2024-02-05', '', '100', 'Torneo abierto de fortnite. Este torneo será eliminatorio y se realizará por equipos de cincuenta personas. El limite de participantes es de 100 jugadores. La fecha de inscripción se deberá realizar unos dos días antes.', ' ', 'yes', '10', '1'),
('Apex Legends tournament', '2024-03-07', '', '100', 'Torneo abierto de Apex Legends. Este torneo será eliminatorio y se realizará por equipos de cincuenta personas. El limite de participantes es de 100 jugadores. La fecha de inscripción se deberá realizar unos diez días antes.', ' ', 'yes', '11', '2'),
('Overwatch 2 tournament', '2020-06-01', '', '200', 'Torneo abierto de Call of Duty. Este torneo será eliminatorio y se realizará por equipos de cinco personas. El limite de participantes es de 200 jugadores. La fecha de inscripción se deberá realizar unos cinco días antes.', 'no', ' ', '12', '3');
