package br.ufms.commands;

import org.apache.commons.net.ftp.FTPClient;

import java.security.InvalidParameterException;

public class ChangeWorkingDirectoryCommand implements Command{
    @Override
    public void execute(String[] params, FTPClient client) throws Exception {
        if(params.length < 1) throw new InvalidParameterException();

        String directory = params[0];

        client.changeWorkingDirectory(directory);
    }

    @Override
    public String getId() {
        return "CWD <diretorio>";
    }

    @Override
    public String getDescription() {
        return "Change Working Directory: Muda o diretório atual.";
    }
}
