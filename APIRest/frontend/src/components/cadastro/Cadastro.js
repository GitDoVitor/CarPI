import "./cadastro.scss";
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import {createMuiTheme, makeStyles, ThemeProvider} from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Imagem from '../../img/foda-min.png';
import {grey} from '@material-ui/core/colors';
import {NavLink} from 'react-router-dom';

const tema = createMuiTheme({
  palette: {
    primary: { main: grey[900] }
  }
});

const useStyles = makeStyles(theme => ({
  paper: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  form: {
    width: '100%', // Fix IE 11 issue.
    marginTop: theme.spacing(3),
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
}));

export default function SignUp() {
  const classes = useStyles();

  return (
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <div className={classes.paper}>
      <a href="/"><img alt="logo" src={ Imagem } id="logo"/></a>
        <form className={classes.form} noValidate>
          <Grid container spacing={2}>
            <ThemeProvider theme={ tema }>
            <Grid item xs={12} sm={6}>
              <TextField name="firstName"required fullWidth id="arrumaFundo" label="Nome" autoFocus />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField required fullWidth id="arrumaFundo" label="Sobrenome" name="lastName" />
            </Grid>
            <Grid item xs={12}>
              <TextField required fullWidth id="arrumaFundo" label="Email" type="email" name="email" />
            </Grid>
            <Grid item xs={12}>
              <TextField required fullWidth name="password" label="Senha" type="password" id="arrumaFundo" />  
            </Grid>
            <Grid item xs={12}>
              <TextField required fullWidth name="endereco" label="Rua" id="arrumaFundo" />  
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField name="numero"required fullWidth id="arrumaFundo" label="Número" />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField fullWidth id="arrumaFundo" label="Complemento" name="complemento" />
            </Grid>
            </ThemeProvider>
          </Grid>
          <Button type="submit" fullWidth variant="contained" className={classes.submit} id="botola">Registrar</Button>
          <Grid container justify="flex-end">
            <Grid item>
              <NavLink to="/login" id='possuiConta'>
                Já Possui Uma Conta?
              </NavLink>
            </Grid>
          </Grid>
        </form>
      </div>
      <Box mt={5}>
      </Box>
    </Container>
  );
}
