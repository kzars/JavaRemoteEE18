package patterns.behavioral.command;

public class CloseFileCommand implements Command {

    private FileSystemReceiver fileSystemReceiver;

    public CloseFileCommand(FileSystemReceiver fs){
        fileSystemReceiver = fs;
    }

    @Override
    public void execute() {
        fileSystemReceiver.closeFile();
    }
}
