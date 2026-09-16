DO $$ BEGIN
    CREATE TYPE tipo_refeicao_enum AS ENUM ('CAFE_MANHA', 'ALMOCO', 'LANCHE', 'JANTAR', 'CEIA');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

DO $$ BEGIN
    CREATE TYPE indice_glicemico_enum AS ENUM ('BAIXO', 'MEDIO', 'ALTO');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

DO $$ BEGIN
    CREATE TYPE dificuldade_enum AS ENUM ('FACIL', 'MEDIO', 'DIFICIL');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

DO $$ BEGIN
    CREATE TYPE objetivo_enum AS ENUM ('PERDA_PESO', 'MANUTENCAO', 'HIPERTROFIA');
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS diario_alimentar (
                                                id BIGSERIAL PRIMARY KEY,
                                                usuario_id BIGINT NOT NULL,
                                                data_refeicao TIMESTAMP NOT NULL,
                                                tipo_refeicao tipo_refeicao_enum NOT NULL,
                                                alimento_id BIGINT NOT NULL,
                                                quantidade_gramas DECIMAL(8,2) NOT NULL,
                                                calorias_calculadas DECIMAL(8,2) NOT NULL,
                                                criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alimentos (
                                         id BIGSERIAL PRIMARY KEY,
                                         nome VARCHAR(100) NOT NULL,
                                         categoria VARCHAR(50) NOT NULL,
                                         calorias_por_100g DECIMAL(6,2) NOT NULL,
                                         proteinas_100g DECIMAL(6,2) NOT NULL,
                                         carboidratos_100g DECIMAL(6,2) NOT NULL,
                                         gorduras_100g DECIMAL(6,2) NOT NULL,
                                         indice_glicemico indice_glicemico_enum DEFAULT 'BAIXO'
);

CREATE TABLE IF NOT EXISTS contraindicacoes_alimento (
                                                         id BIGSERIAL PRIMARY KEY,
                                                         alimento_id BIGINT NOT NULL,
                                                         condicao_medica VARCHAR(50) NOT NULL,
                                                         FOREIGN KEY (alimento_id) REFERENCES alimentos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS receitas (
                                        id BIGSERIAL PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
                                        descricao TEXT,
                                        tempo_preparo_min INT NOT NULL,
                                        dificuldade dificuldade_enum DEFAULT 'FACIL',
                                        instrucoes TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS metas_nutricionais (
                                                  id BIGSERIAL PRIMARY KEY,
                                                  usuario_id BIGINT NOT NULL UNIQUE,
                                                  meta_calorica_diaria DECIMAL(6,2) NOT NULL,
                                                  meta_proteinas_g DECIMAL(6,2) NOT NULL,
                                                  meta_carboidratos_g DECIMAL(6,2) NOT NULL,
                                                  meta_gorduras_g DECIMAL(6,2) NOT NULL,
                                                  objetivo objetivo_enum NOT NULL,
                                                  atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS registros_exercicios (
                                                    id BIGSERIAL PRIMARY KEY,
                                                    usuario_id BIGINT NOT NULL,
                                                    data_exercicio TIMESTAMP NOT NULL,
                                                    tipo_exercicio VARCHAR(50) NOT NULL,
                                                    duracao_minutos INT NOT NULL,
                                                    calorias_queimadas DECIMAL(6,2) NOT NULL,
                                                    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION update_atualizado_em_column()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.atualizado_em = NOW();
    RETURN NEW;
END;
$$ language 'plpgsql';

DROP TRIGGER IF EXISTS set_atualizado_em ON metas_nutricionais;
CREATE TRIGGER set_atualizado_em
    BEFORE UPDATE ON metas_nutricionais
    FOR EACH ROW
EXECUTE FUNCTION update_atualizado_em_column();


INSERT INTO alimentos (nome, categoria, calorias_por_100g, proteinas_100g, carboidratos_100g, gorduras_100g, indice_glicemico) VALUES
                                                                                                                                   ('Arroz Integral Cozido', 'Grains', 130.00, 2.60, 28.00, 1.00, 'BAIXO'),
                                                                                                                                   ('Peito de Frango Grelhado', 'Proteínas', 165.00, 31.00, 0.00, 3.60, 'BAIXO'),
                                                                                                                                   ('Castanha do Pará', 'Oleaginosas', 650.00, 14.00, 12.00, 66.00, 'BAIXO'),
                                                                                                                                   ('Doces e Açúcar Refinado', 'Sobremesas', 387.00, 0.00, 99.00, 0.00, 'ALTO');

INSERT INTO diario_alimentar (usuario_id, data_refeicao, tipo_refeicao, alimento_id, quantidade_gramas, calorias_calculadas) VALUES
                                                                                                                                 (1, NOW() - INTERVAL '4 hours', 'ALMOCO', 1, 150.00, 195.00),
                                                                                                                                 (1, NOW() - INTERVAL '4 hours', 'ALMOCO', 2, 100.00, 165.00),
                                                                                                                                 (1, NOW() - INTERVAL '1 hour', 'LANCHE', 3, 30.00, 180.00);

INSERT INTO contraindicacoes_alimento (alimento_id, condicao_medica) VALUES
    (4, 'glicemia_alta');

INSERT INTO receitas (nome, descricao, tempo_preparo_min, dificuldade, instrucoes) VALUES
                                                                                       ('Omelete com Espinafre e Queijo Branco', 'Refeição leve, alta em proteínas e de baixo índice glicêmico.', 15, 'FACIL', 'Bata 2 ovos, adicione espinafre picado e queijo minas em cubos. Doure na frigideira antiaderente.'),
                                                                                       ('Salada de Quinoa com Frango', 'Almoço nutritivo e rico em fibras.', 25, 'MEDIO', 'Misture a quinoa cozida com peito de frango desfiado, tomate, pepino e azeite.');

INSERT INTO metas_nutricionais (usuario_id, meta_calorica_diaria, meta_proteinas_g, meta_carboidratos_g, meta_gorduras_g, objetivo) VALUES
    (1, 2000.00, 150.00, 200.00, 60.00, 'PERDA_PESO');

INSERT INTO registros_exercicios (usuario_id, data_exercicio, tipo_exercicio, duracao_minutos, calorias_queimadas) VALUES
    (1, NOW() - INTERVAL '2 hours', 'Corrida Moderada', 45, 420.00);