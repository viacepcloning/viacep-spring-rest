INSERT INTO address(cep,logradouro,complemento,bairro,localidade,uf,ibge, gia,ddd,siafi) VALUES ('90110170', 'Rua Dezessete de Junho', 'complemento', 'Menino Deus', 'Porto Alegre', 'RS', 'ibge', 'gia', 'ddd', 'siafi') ON CONFLICT DO NOTHING;

