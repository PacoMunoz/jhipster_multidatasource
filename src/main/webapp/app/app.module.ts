import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { MultidatasourcesSharedModule } from 'app/shared/shared.module';
import { MultidatasourcesCoreModule } from 'app/core/core.module';
import { MultidatasourcesAppRoutingModule } from './app-routing.module';
import { MultidatasourcesHomeModule } from './home/home.module';
import { MultidatasourcesEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    MultidatasourcesSharedModule,
    MultidatasourcesCoreModule,
    MultidatasourcesHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    MultidatasourcesEntityModule,
    MultidatasourcesAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class MultidatasourcesAppModule {}
