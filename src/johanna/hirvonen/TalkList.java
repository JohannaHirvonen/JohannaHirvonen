package johanna.hirvonen;

public class TalkList {
	
	public Talk first;
	public Talk last;
	public Talk noChoice;
	
	public void makeTalks(){
		Talk hello = new Talk("Hello! \n\nMy name is Johanna", null);
		Talk dream = new Talk("I have searched long and hard for my dreamjob." , null);
		hello.next = dream;
		Talk shop = new Talk("I tried at \nthe coffee shop and \nthe pretty thing´s shop...", null);
		dream.next = shop;
		Talk care = new Talk("social care \nand \nkindergarten", null);
		shop.next = care;
		Talk found = new Talk("But now I have finally found what I'm looking for.", null);
		care.next = found;
		Talk code = new Talk(null, "/Code.jpg");
		found.next = code;
		Talk love = new Talk("I just love it!");
		code.next = love;
		Talk school = new Talk("So I'm going to school", "/logoEC.png");
		love.next = school;
		Talk java = new Talk("And I'm learning about programming in Java", null);
		school.next = java;
		Talk structures = new Talk("Data structures and algorithms", null);
		java.next = structures;
		Talk android = new Talk("Android apps, network programming", null);
		structures.next = android;
		Talk web = new Talk("Javascript and XML", null);
		android.next = web;
		Talk well = new Talk("I think it's going pretty well...", null);
		web.next = well;
		Talk more = new Talk("But I want to learn", "/more.jpg");
		well.next = more;
		Talk awesome = new Talk("I want to be", "/awesome.jpg");
		more.next = awesome;
		Talk you = new Talk("And that's where you come in...", null);
		awesome.next = you;
		Talk internship = new Talk("My last course is six weeks of internship", "\n\nApril 28 - June 5\n2014", true);
		you.next = internship;
		Talk company = new Talk("And I would love to do it at your company.", null);
		internship.next = company;
		Talk deal = new Talk("So what do you say?", "DEAL", "or", "NO DEAL", "The details");
		company.next = deal;
		Talk yes = new Talk("Yes! This will be great! I'm waiting for your call:", "johannahirvonen86@gmail.com \n\n+4673 667 04 65", true);
		deal.next = yes;
		Talk no = new Talk("No? Too bad, but I'll give you some time to ", "RECONSIDER", " ");
		deal.noTalk = no;
		noChoice = no;
		no.next = deal;
		first = hello;
		last = deal;	
	}
}
