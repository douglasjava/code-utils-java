# Vá para a pasta de download
cd /tmp

# Baixe a versão específica (3.17.3) para MacOS
curl -LO https://github.com/protocolbuffers/protobuf/releases/download/v3.17.3/protoc-3.17.3-osx-x86_64.zip

# Extraia o conteúdo
unzip protoc-3.17.3-osx-x86_64.zip -d protoc-3.17.3

# Mova para /usr/local (ou outro diretório do seu PATH)
sudo mv protoc-3.17.3/bin/protoc /usr/local/bin/

# Opcional: mover também os includes
sudo mv protoc-3.17.3/include/* /usr/local/include/