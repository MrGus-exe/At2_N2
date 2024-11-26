
Gerenciamento Estudantil - Documentação do Projeto
Descrição do Projeto
O Gerenciamento Estudantil é um sistema em Java desenvolvido para facilitar o controle e a gestão de dados acadêmicos, incluindo informações sobre alunos, professores e cursos. O sistema oferece funcionalidades de cadastro, consulta, edição, exclusão, e geração de relatórios, garantindo a persistência dos dados através de arquivos de texto.

O projeto foi desenvolvido com a interface gráfica Swing, aplicando os conceitos de Programação Orientada a Objetos (POO).

Funcionalidades
1. Tela Inicial
Apresenta as opções principais do sistema:
Gerenciar Alunos
Gerenciar Professores
Gerenciar Cursos
Sair do Programa
2. Gerenciamento de Alunos
Cadastrar Aluno
Permite registrar um aluno informando:
Nome
Idade
Matrícula
Os dados são armazenados em um arquivo de texto (alunos.txt).
Consultar Aluno
Pesquisa por nome ou matrícula.
Exibe as informações do aluno com opções para:
Editar: Atualizar nome ou idade.
Excluir: Remover o registro do aluno.
As alterações são salvas no arquivo alunos.txt.
3. Gerenciamento de Professores
Cadastrar Professor
Permite registrar um professor informando:
Nome
Especialidade
Os dados são armazenados em um arquivo de texto (professores.txt).
Consultar Professor
Pesquisa por nome ou matrícula.
Exibe as informações do professor com opções para:
Editar: Atualizar nome ou especialidade.
Excluir: Remover o registro do professor.
As alterações são salvas no arquivo professores.txt.
4. Gerenciamento de Cursos
Cadastrar Curso

Permite registrar um curso informando:
Nome do Curso
Carga Horária
Os dados são armazenados em um arquivo de texto (cursos.txt).
Consultar Curso

Pesquisa por nome do curso.
Exibe as informações do curso com opções para:
Editar: Atualizar nome ou carga horária.
Excluir: Remover o registro do curso.
As alterações são salvas no arquivo cursos.txt.
Vincular Alunos e Professores

Permite:
Matricular alunos em cursos.
Associar professores como responsáveis por cursos.
As informações são armazenadas no arquivo vinculacoes.txt.
5. Geração de Relatórios
Relatório de Alunos
Lista todos os alunos cadastrados e os cursos nos quais estão matriculados.
Relatório de Professores
Lista todos os professores cadastrados e os cursos nos quais são responsáveis.
Estrutura do Projeto
1. Classes Principais
Pessoa (Classe Abstrata)
Atributos:
Nome
Idade
Métodos:
Getters e setters.
Método abstrato exibirDados().
Estudante (Subclasse de Pessoa)
Atributo adicional:
Matrícula
Métodos:
Manipulação de dados (cadastro, edição, exclusão).
Implementação de exibirDados().
Professor (Subclasse de Pessoa)
Atributo adicional:
Especialidade
Métodos:
Manipulação de dados (cadastro, edição, exclusão).
Implementação de exibirDados().
Curso
Atributos:
Nome do curso
Carga horária
Professor responsável
Métodos:
Manipulação de cursos e associações.
GerenciadorDeArquivos
Métodos:
Leitura e escrita de arquivos.
Manipulação de persistência (alunos.txt, professores.txt, cursos.txt, vinculacoes.txt).
Relatorios
Atributos:
Listas de alunos, professores e cursos.
Mapas para matrículas e associações.
Métodos:
Geração de relatórios.
2. Interface Gráfica (Swing)
JanelaPrincipal:
Permite a navegação entre as telas de Alunos, Professores e Cursos.
TelaCadastroAluno, TelaConsultaAluno:
Realizam operações específicas para os alunos.
TelaCadastroProfessor, TelaConsultaProfessor:
Realizam operações específicas para os professores.
TelaCadastroCurso, TelaConsultaCurso:
Realizam operações específicas para os cursos.
Fluxo do Sistema
O usuário inicia o sistema na JanelaPrincipal.
Escolhe uma das opções: Aluno, Professor, ou Curso.
Realiza operações de cadastro, consulta, edição ou exclusão.
O sistema armazena as informações em arquivos de texto e reflete as alterações nas próximas execuções.
Como Executar o Projeto
Certifique-se de ter o Java JDK instalado na máquina.
Compile os arquivos .java usando o terminal ou uma IDE (exemplo: IntelliJ IDEA, Eclipse, NetBeans).
Certifique-se de que a estrutura de pastas para os arquivos de texto existe:
dados/alunos.txt
dados/professores.txt
dados/cursos.txt
dados/vinculacoes.txt
Execute o programa a partir da classe JanelaPrincipal.
Contribuições
Organização do Código: Divisão modular com comentários explicativos.
Persistência de Dados: Arquivos de texto para manter os registros entre as execuções.
Interface Intuitiva: Navegação simples e clara através de botões e janelas.
Melhorias Futuras
Utilizar um banco de dados relacional (como SQLite ou MySQL) para gerenciar os dados.
Adicionar suporte para validações mais complexas e autenticação de usuários.
Melhorar o design da interface gráfica para torná-la mais moderna.
