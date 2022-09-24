package patterns.behavioral.command;

public class FileSystemClient {
    public static void main(String[] args) {

        //Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        //creating command and associating with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);

        //Creating invoker and associating with command
        FileInvoker fileInvoker = new FileInvoker(openFileCommand);

        //perform action on invoker object
        fileInvoker.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        fileInvoker = new FileInvoker(writeFileCommand);
        fileInvoker.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        fileInvoker = new FileInvoker(closeFileCommand);
        fileInvoker.execute();



    }
}
