package emailApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class EmailFrame extends JFrame {
    private JPanel panel;
    private JTextField textFieldName;
    private JLabel nameLable;
    private JLabel structureLable;
    private JLabel manageLabel;
    private JLabel itLable;
    private JLabel accoLabel;
    private JLabel marketLabel;
    private JLabel expoLabel;
    private JLabel logistLable;
    private JLabel wearhouseLable;
    private JLabel chooserLable;
    private JTextField textFieldDepartment;
    private JButton buttonGenerate;
    private JTextArea textArea1;
    private JLabel blankLabel;
    private JLabel blank2Label;
    private JLabel blank3Label;
    private JLabel lastNameLabel;
    private JTextField textField1;
    private JScrollPane scrollPane;
    private String firstName;
    private String lastName;
    private int id = 0;
    private FileWriter fileWriter;
    private String password;
    private String department;
    private String email;
    private String companySuffix = "company.com";
    private int mailBoxCapasity = 500;
    private int defaultPasswordLength = 10;

    // Constructor to receive the frame and all components ready to use

    public EmailFrame()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tworzenie maila i hasła");
        this.setBounds(250, 250, 600, 500);
        this.getContentPane().add(panel);

        setBorders();
        setFonts();

        // ActionListener for button, nameField and lastNameField

        buttonGenerate.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String check = textArea1.getText();
                if (!check.equalsIgnoreCase(" ") || check.equalsIgnoreCase(" "))
                {
                    id++;

                    // Call a method asking for the department - return department

                    department = setDepartment();
                    email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

                    // Call the methods returns a random password

                    password = randomPassword(defaultPasswordLength);

                    // Setting text on textArea

                    textArea1.setText(check + "\nNowy pracownik: " + firstName + " " + lastName +
                            "\n\nTwoje nowe hasło: " + password + "\n" + showInfo());

                    // Call the method to save the text to file

                    saveToFile();
                }
            }
        });

        textFieldName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                firstName = textFieldName.getText();
                System.out.println("Imie");
            }
        });
        textField1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                lastName = textField1.getText();
                System.out.println("Imie 22222");
            }
        });
    }

    // Ask for the department

    private String setDepartment()
    {
        String number = textFieldDepartment.getText();

        if (number.equalsIgnoreCase("1"))
        {
            return "zarzad";

        } else if (number.equalsIgnoreCase("2"))
        {
            return "it";

        } else if (number.equalsIgnoreCase("3"))
        {
            return "ksieg";

        } else if (number.equalsIgnoreCase("4"))
        {
            return "hand";

        } else if (number.equalsIgnoreCase("5"))
        {
            return "export";

        } else if (number.equalsIgnoreCase("6"))
        {
            return "logist";

        } else if (number.equalsIgnoreCase("7"))
        {
            return "mag";

        } else
            {
            return "";
            }
    }

    // Generate a random password

    private String randomPassword(int length)
    {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";

        char[] password = new char[length];

        for (int i = 0; i < length; i++)
        {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Setting text on textArea

    public String showInfo()
    {
        return "ID firmowe: " + id +
                "\nImię i nazwisko: " + firstName + " " + lastName +
                "\nFirmowy email: " + email +
                "\nPojemność skrzynki pocztowej: " + mailBoxCapasity + "mb \n\n";
    }

    // Saving text to the file

    public void saveToFile()
    {
        {
            String filePath = "Dane.txt";
            String save = textArea1.getText();
            fileWriter = null;

            // saving a text from the textArea to the new file "Dane.txt"

            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.write(save);

                if (fileWriter != null)
                {
                    fileWriter.close();
                }
                } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }

    // Setting borders

    public void setBorders()
    {
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panel.setBackground(Color.lightGray);
        buttonGenerate.setBackground(Color.cyan);
    }

    // Setting fonts

    public void setFonts()
    {
        Font font = new Font("New Roman", Font.BOLD, 15);

        textArea1.setFont(font);
        buttonGenerate.setFont(font);
        textField1.setFont(font);
        textFieldName.setFont(font);
        textFieldDepartment.setFont(font);
    }

    // Set the mailbox capacity

    public void setMailBoxCapasity(int capasity)
    {
        this.mailBoxCapasity = capasity;
    }

    // Set the textArea

    public void setTextArea1(String textArea1)
    {
        this.textArea1 = getTextArea1();
    }

    // Change the password

    public void changePassword(String password)
    {
        this.password = password;
    }

    // Call getters

    public int getMailBoxCapasity()
    {
        return mailBoxCapasity;
    }

    public String getPassword()
    {
        return password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public JTextArea getTextArea1()
    {
        return textArea1;
    }

    public String getEmail()
    {
        return email;
    }

    public int getId()
    {
        return id;
    }

    public FileWriter getFileWriter()
    {
        return fileWriter;
    }
}