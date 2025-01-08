import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EClassGUI extends JFrame {
    // 정의 + 조정
    JPanel loginPanel = new BasicBackgroundPanel(new ImageIcon("Image/로그인 페이지 - 중앙대.jpg").getImage());;
    JPanel dashboardPanel = new JPanel();
    JPanel softwareProjectPanel = new JPanel();;
    JPanel assignmentEvaluationPanel = new JPanel();;
    JPanel finalsubmissionPanel = new JPanel();;
    CardLayout cardLayout = new CardLayout();
    JTextField userIdField;
    JPasswordField passwordField;
    JLabel loginStatusLabel;

    // 요약내용 + 정의 - 두군데에다가 표시하기 위함
    String summaryText = "마감: 6월 17일 기준. 오후 11:59\n점수: 0\n제출물 유형: 파일 업로드\n이용 가능: 6월 5일 오전 12:00 - 6월 17일 오후 11:59 13일";
    JTextArea assignmentboard;
    JTextArea finalboard;


    // 아이디 비밀번호 + 정의(final 활용)
    final String Id = "1";
    final String Password = "1";

    public EClassGUI() {
        setTitle("EClass");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLayout(cardLayout);

        // 패널 생성 및 초기화
        LoginPanel();
        DashboardPanel();
        SoftwareProjectPanel();
        AssignmentEvaluationPanel();
        FinalsubmissionPanel();

        add(loginPanel, "로그인");
        add(dashboardPanel, "대시 보드");
        add(softwareProjectPanel, "소프트웨어 프로젝트");
        add(assignmentEvaluationPanel, "과제 및 평가");
        add(finalsubmissionPanel, "최종과제 제출");

        // 로그인 첫 시도
        cardLayout.show(getContentPane(), "로그인");

        setVisible(true);
    }

    void LoginPanel() {
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userIdLabel = new JLabel(" 아이디:");
        userIdField = new JTextField(20);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("로그인");
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(33, 85, 164));
        loginStatusLabel = new JLabel("", JLabel.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(userIdLabel, gbc); //(0,0)

        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc); //(0,1)

        gbc.gridx = 1;
        gbc.gridy = 0;
        loginPanel.add(userIdField, gbc); //(1,0)
        gbc.gridy = 1;
        loginPanel.add(passwordField, gbc); //(1,1)

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        gbc.gridy = 3;
        loginPanel.add(loginStatusLabel, gbc);
    }

    void DashboardPanel() {
        dashboardPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        Dimension buttonSize = new Dimension(200, 50);

        JButton compProgrammingButton = new JButton("기초컴퓨터 프로그래밍");
        JButton swProjectButton = new JButton("소프트웨어 프로젝트");
        swProjectButton.setOpaque(true);
        swProjectButton.setBorderPainted(false);
        swProjectButton.setForeground(Color.WHITE);
        swProjectButton.setBackground(new Color(33, 85, 164));
        JButton itIntroButton = new JButton("IT개론");
        JButton regressionButton = new JButton("회귀분석");
        JButton deepLearningButton = new JButton("AI를 위한 딥러닝");

        compProgrammingButton.setPreferredSize(buttonSize);
        swProjectButton.setPreferredSize(buttonSize);
        itIntroButton.setPreferredSize(buttonSize);
        regressionButton.setPreferredSize(buttonSize);
        deepLearningButton.setPreferredSize(buttonSize);

        swProjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "소프트웨어 프로젝트");
            }
        });

        JLabel todoLabel = new JLabel("할일", JLabel.CENTER);
        JTextArea todoBoard = new JTextArea(10, 20);
        todoBoard.setEditable(false);
        JScrollPane todoScrollPane = new JScrollPane(todoBoard);

        JLabel feedbackLabel = new JLabel("최근 피드백", JLabel.CENTER);
        JTextArea feedbackBoard = new JTextArea(10, 20);
        feedbackBoard.setEditable(false);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackBoard);

        // 이미지 버튼
        ImageIcon image1 = new ImageIcon("Image/기초컴퓨터프로그래밍.png");
        ImageIcon image2 = new ImageIcon("Image/소프트웨어프로젝트.png");
        ImageIcon image3 = new ImageIcon("Image/회귀분석.png");
        ImageIcon image4 = new ImageIcon("Image/AI딥.png");
        ImageIcon image5 = new ImageIcon("Image/IT개론.png");

        Dimension imageSize = new Dimension(200, 200);

        JButton imageButton1 = new JButton(image1);
        imageButton1.setPreferredSize(imageSize);
        JButton imageButton2 = new JButton(image2);
        imageButton2.setPreferredSize(imageSize);
        JButton imageButton3 = new JButton(image3);
        imageButton3.setPreferredSize(imageSize);
        JButton imageButton4 = new JButton(image4);
        imageButton4.setPreferredSize(imageSize);
        JButton imageButton5 = new JButton(image5);
        imageButton5.setPreferredSize(imageSize);

        imageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "소프트웨어 프로젝트");
            }
        });

        // 1번째 줄 (y = 0)
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        dashboardPanel.add(compProgrammingButton, gbc); //(0, 0)

        gbc.gridx = 1;
        dashboardPanel.add(swProjectButton, gbc); // (1, 0)

        gbc.gridx = 2;
        dashboardPanel.add(itIntroButton, gbc); // (2, 0)

        // 3번째 줄 (y = 2)
        gbc.gridx = 0;
        gbc.gridy = 2;
        dashboardPanel.add(regressionButton, gbc); // (0, 2)

        gbc.gridx = 1;
        dashboardPanel.add(deepLearningButton, gbc); // (1, 2)

        // 왼쪽부분 처리
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        dashboardPanel.add(todoLabel, gbc); // (4, 0)

        gbc.gridy = 1;
        dashboardPanel.add(todoScrollPane, gbc); // (4, 1)

        gbc.gridy = 2;
        dashboardPanel.add(feedbackLabel, gbc); // (4, 2)

        gbc.gridy = 3;
        dashboardPanel.add(feedbackScrollPane, gbc); // (4, 3)

        // EClass 이미지 버튼
        // 첫번째 줄 (y = 1)
        gbc.gridy = 1;
        gbc.gridx = 0;
        dashboardPanel.add(imageButton1, gbc); // (0, 1)

        gbc.gridx = 1;
        dashboardPanel.add(imageButton2, gbc); // (1, 1)

        gbc.gridx = 2;
        dashboardPanel.add(imageButton3, gbc); // (2, 1)

        // 두번째 줄 (y = 3)
        gbc.gridy = 3;
        gbc.gridx = 0;
        dashboardPanel.add(imageButton4, gbc); // (0, 3)

        gbc.gridx = 1;
        dashboardPanel.add(imageButton5, gbc); // (1, 3)
    }

    void SoftwareProjectPanel() {
        softwareProjectPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        Dimension buttonSize = new Dimension(200, 50);

        String[] buttonLabels = {"홈", "수업계획서", "주차학습(모듈)", "출결현황", "사용자 및 그룹", "성적", "과제 및 평가", "zoom", "전자출석부", "게시판", "강의자료실"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setMaximumSize(buttonSize);
            if (label.equals("과제 및 평가")) {
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(33, 85, 164));

            }

            leftPanel.add(button);
            leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            if (label.equals("과제 및 평가")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        cardLayout.show(getContentPane(), "과제 및 평가");
                    }
                });
            }
        }

        JButton backButton = new JButton("뒤로가기");
        backButton.setMaximumSize(buttonSize);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 0, 0));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "대시 보드");
            }
        });
        leftPanel.add(backButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel recentActivityLabel = new JLabel("최근활동", JLabel.CENTER);
        JTextArea recentActivityBoard = new JTextArea(10, 10);
        recentActivityBoard.setEditable(false);
        JScrollPane recentActivityScrollPane = new JScrollPane(recentActivityBoard);

        JLabel subjectCalendarLabel = new JLabel("과목 캘린더", JLabel.CENTER);
        JTextArea subjectCalendarBoard = new JTextArea(10, 10);
        subjectCalendarBoard.setEditable(false);
        JScrollPane subjectCalendarScrollPane = new JScrollPane(subjectCalendarBoard);

        JLabel subjectNotificationLabel = new JLabel("과목 알림", JLabel.CENTER);
        JTextArea subjectNotificationBoard = new JTextArea(10, 10);
        subjectNotificationBoard.setEditable(false);
        JScrollPane subjectNotificationScrollPane = new JScrollPane(subjectNotificationBoard);

        JLabel todoLabel = new JLabel("할일", JLabel.CENTER);
        JTextArea todoBoard = new JTextArea(10, 10);
        todoBoard.setEditable(false);
        JScrollPane todoScrollPane = new JScrollPane(todoBoard);

        JLabel feedbackLabel = new JLabel("최근 피드백", JLabel.CENTER);
        JTextArea feedbackBoard = new JTextArea(10, 10);
        feedbackBoard.setEditable(false);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackBoard);

        centerPanel.add(recentActivityLabel);
        centerPanel.add(recentActivityScrollPane);
        centerPanel.add(subjectCalendarLabel);
        centerPanel.add(subjectCalendarScrollPane);
        centerPanel.add(subjectNotificationLabel);
        centerPanel.add(subjectNotificationScrollPane);
        centerPanel.add(todoLabel);
        centerPanel.add(todoScrollPane);
        centerPanel.add(feedbackLabel);
        centerPanel.add(feedbackScrollPane);

        softwareProjectPanel.add(leftPanel, BorderLayout.WEST);
        softwareProjectPanel.add(centerPanel, BorderLayout.CENTER);
    }

    void AssignmentEvaluationPanel() {
        assignmentEvaluationPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        JLabel summaryLabel = new JLabel("요약", JLabel.CENTER);
        assignmentboard = new JTextArea(10, 50);
        assignmentboard.setText(summaryText);
        assignmentboard.setEditable(false);
        JScrollPane summaryScrollPane = new JScrollPane(assignmentboard);

        JLabel assignmentLabel = new JLabel("과제", JLabel.CENTER);
        JButton finalButton = new JButton("최종과제 제출");
        finalButton.setOpaque(true);
        finalButton.setBorderPainted(false);
        finalButton.setForeground(Color.WHITE);
        finalButton.setBackground(new Color(33, 85, 164));
        JLabel evaluationLabel = new JLabel("평가", JLabel.CENTER);
        JButton evaluationButton = new JButton("시험");

        finalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "최종과제 제출");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        assignmentEvaluationPanel.add(assignmentLabel, gbc);

        gbc.gridy = 1;
        assignmentEvaluationPanel.add(summaryLabel, gbc);

        gbc.gridy = 2;
        assignmentEvaluationPanel.add(summaryScrollPane, gbc);

        gbc.gridy = 3;
        assignmentEvaluationPanel.add(finalButton, gbc);

        gbc.gridy = 4;
        assignmentEvaluationPanel.add(evaluationLabel, gbc);

        gbc.gridy = 5;
        assignmentEvaluationPanel.add(evaluationButton, gbc);

        JButton backButton = new JButton("뒤로가기");
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 0, 0));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "소프트웨어 프로젝트");
            }
        });

        gbc.gridy = 6;
        assignmentEvaluationPanel.add(backButton, gbc);
    }

    void FinalsubmissionPanel() {
        finalsubmissionPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        JLabel summaryLabel = new JLabel("요약", JLabel.CENTER);
        finalboard = new JTextArea(10, 50);
        finalboard.setText(summaryText);
        finalboard.setEditable(false);
        JScrollPane summaryScrollPane = new JScrollPane(finalboard);

        JButton submitFinalAssignmentButton = new JButton("최종과제 제출");
        submitFinalAssignmentButton.setForeground(Color.WHITE);
        submitFinalAssignmentButton.setBackground(new Color(33, 85, 164));
        submitFinalAssignmentButton.setOpaque(true);
        submitFinalAssignmentButton.setBorderPainted(false);
        // 파일 추가 내용
        class OpneActionListener implements ActionListener {
            JFileChooser chooser;

            OpneActionListener() {
                chooser = new JFileChooser();
            }
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
                chooser.setFileFilter(filter);

                int ret = chooser.showOpenDialog(null);
                if(ret != JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(null, "파일 선택 되지 않음", "파일 선택 되지 않음", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String filePath = chooser.getSelectedFile().getPath();
                pack();
            }
        }
        submitFinalAssignmentButton.addActionListener(new OpneActionListener());

        JButton backButton = new JButton("뒤로가기");
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 0, 0));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(getContentPane(), "과제 및 평가");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        finalsubmissionPanel.add(summaryLabel, gbc);

        gbc.gridy = 1;
        finalsubmissionPanel.add(summaryScrollPane, gbc);

        gbc.gridy = 2;
        finalsubmissionPanel.add(submitFinalAssignmentButton, gbc);

        gbc.gridy = 3;
        finalsubmissionPanel.add(backButton, gbc);
    }

    void Login() {
        String userId = userIdField.getText();
        String password = new String(passwordField.getPassword());

        if (Id.equals(userId) && Password.equals(password)) {
            cardLayout.show(getContentPane(), "대시 보드");
        } else {
            loginStatusLabel.setText("로그인 실패");
            userIdField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new EClassGUI();
            }
        });
    }
}
// 배경화면 관련
class BasicBackgroundPanel extends JPanel {
    private Image background;

    public BasicBackgroundPanel(Image background) {
        this.background = background;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
