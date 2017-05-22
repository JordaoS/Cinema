import { FrontRelatorioPage } from './app.po';

describe('front-relatorio App', () => {
  let page: FrontRelatorioPage;

  beforeEach(() => {
    page = new FrontRelatorioPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
