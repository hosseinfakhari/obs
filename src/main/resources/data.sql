INSERT INTO observation_type (id, name, unit) VALUES (1, 'heart-rate', 'beats/minute') ON CONFLICT (id) DO NOTHING;
INSERT INTO observation_type (id, name, unit) VALUES (2, 'respiratory-rate', 'breaths/minute') ON CONFLICT (id) DO NOTHING;
INSERT INTO observation_type (id, name, unit) VALUES (3, 'skin-temperature', 'degrees-celsius') ON CONFLICT (id) DO NOTHING;
