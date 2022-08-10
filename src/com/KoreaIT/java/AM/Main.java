package com.KoreaIT.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		int lastArticleID = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			if (cmd.equals("article write")) {
				int id = lastArticleID + 1;
				lastArticleID = id;
				System.out.printf("제목: ");
				String title = sc.nextLine();
				System.out.printf("내용: ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번 글이 생성되었습니다.\n", id);

			} else if (cmd.equals("article list")) {
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				} else {
					System.out.println("게시글이 있습니다.");
				}
			} else {
				System.out.println("존재하지 않는 명령어입니다");
			}

		}

		sc.close();

		System.out.println("==프로그램 끝==");
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}